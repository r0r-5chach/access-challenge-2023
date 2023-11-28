package xyz.r0r5chach.api.patient.search;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;

import xyz.r0r5chach.api.patient.Gender;

public class Search {
    private boolean fuzzyMatch, exactMatch, history;
    private int maxResults;
    private String family, addressPostalCode, generalPractitioner, email, phone;
    private List<String> given;
    private List<Pair<Comparator,String>> birthDate, deathDate;
    private Gender gender;

    public Search() {
        given = new ArrayList<>();
        birthDate = new ArrayList<>();
    }
    public Search setFuzzyMatch(boolean fuzzyMatch) {
        this.fuzzyMatch = fuzzyMatch;

        return this;
    }
    public Search setExactMatch(boolean exactMatch) {
        this.exactMatch = exactMatch;

        return this;
    }
    public Search setHistory(boolean history) {
        this.history = history;

        return this;
    }
    public Search setMaxResults(int maxResults) {
        this.maxResults = maxResults;

        return this;
    }
    public Search setFamily(String family) {
        this.family = family;

        return this;
    }
    public Search setAddressPostalCode(String addressPostalCode) {
        this.addressPostalCode = addressPostalCode;

        return this;
    }
    public Search setGeneralPractitioner(String generalPractitioner) {
        this.generalPractitioner = generalPractitioner;

        return this;
    }
    public Search setEmail(String email) {
        this.email = email;

        return this;
    }
    public Search setPhone(String phone) {
        this.phone = phone;

        return this;
    }
    public Search addGiven(String givenString) {
        given.add(givenString);

        return this;
    }
    public Search addBirthDate(String birthDateString, Comparator comparator) {
        birthDate.add(new Pair<Comparator,String>(comparator, birthDateString));

        return this;
    }
    public Search setGender(Gender gender) {
        this.gender = gender;

        return this;
    }
    public Search setDeathDate(String deathDateString, Comparator comparator) {
        deathDate.add(new Pair<Comparator,String>(comparator, deathDateString));

        return this;
    }

    public String toParamsString() {
        StringBuilder out = new StringBuilder();
        out.append("_fuzzy-match=").append(urlEncodeValue(String.valueOf(fuzzyMatch)))
           .append("&_exact-match=").append(urlEncodeValue(String.valueOf(exactMatch)))
           .append("&_history=").append(urlEncodeValue(String.valueOf(history)))
           .append("&_max_results=").append(urlEncodeValue(String.valueOf(maxResults)))
           .append("&family=").append(urlEncodeValue(family))
           .append(urlEncodeList("given", given))
           .append(urlEncodeDateList("birthdate", birthDate));

           if (gender != null) {
                out.append("&gender=").append(urlEncodeValue(gender.toString()));
           }

           if (deathDate != null) {
                out.append(urlEncodeDateList("death-date", deathDate));
           }

           if (addressPostalCode != null) {
                out.append("&address-postalcode=").append(urlEncodeValue(addressPostalCode));
           }

           if (generalPractitioner != null) {
                out.append("&general-practitioner=").append(urlEncodeValue(generalPractitioner));
           }

           if (email != null) {
                out.append("&email=").append(urlEncodeValue(email));
           }

           if (phone != null) {
                out.append("&phone=").append(urlEncodeValue(phone));
           }

           

           return out.toString();
    }

    private String urlEncodeValue(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        }
        catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    private String urlEncodeList(String key, List<String> list) {
        StringBuilder out = new StringBuilder();

        for (String item : list) {
            out.append("&").append(key).append("=").append(item);
        }

        return out.toString();
    }

    private String urlEncodeDateList(String key, List<Pair<Comparator,String>> list) {
        StringBuilder out = new StringBuilder();

        for (Pair<Comparator,String> item : list) {
            out.append("&").append(key).append("=").append(item.getValue0()).append(item.getValue1());
        }

        return out.toString();
    }
}
