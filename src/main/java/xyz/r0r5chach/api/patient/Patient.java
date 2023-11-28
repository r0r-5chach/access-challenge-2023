package xyz.r0r5chach.api.patient;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.bson.Document;

import xyz.r0r5chach.api.patient.address.Address;
import xyz.r0r5chach.api.patient.name.Name;
import xyz.r0r5chach.api.patient.relationship.Relationship;
import xyz.r0r5chach.api.patient.telecom.Contact;
import xyz.r0r5chach.api.patient.telecom.Telecom;

public class Patient {
    private String id;
    private List<Identifier> identifier;
    private Meta meta;
    private List<Name> name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDateTime deceasedDateTime;
    private int multipleBirthInteger;
    private List<Address> address;
    private List<Telecom> telecom;
    private List<Contact> contact;
    private List<Relationship> relationships;
    private List<GeneralPractitioner> generalPractitioner;

    public Patient(String id, List<Identifier> identifier, Meta meta, List<Name> name, Gender gender,
            LocalDate birthDate, LocalDateTime deceasedDateTime, int multipleBirthInteger, List<Address> address,
            List<Telecom> telecom, List<Contact> contact, List<GeneralPractitioner> generalPractitioner) {
        this.id = id;
        this.identifier = identifier;
        this.meta = meta;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deceasedDateTime = deceasedDateTime;
        this.multipleBirthInteger = multipleBirthInteger;
        this.address = address;
        this.telecom = telecom;
        this.contact = contact;
        this.generalPractitioner = generalPractitioner;
    }

    public Patient(Document res) {
        this.id = res.getString("id");
        this.identifier = res.getList("identifier", Identifier.class, null);
        this.meta = res.get("meta", Meta.class);
        this.name = res.getList("name", Name.class, null);
        this.gender = res.get("gender", Gender.class);
        this.birthDate = res.get("birthDate", LocalDate.class);
        this.multipleBirthInteger = res.getInteger("multipleBirthInteger");
        this.deceasedDateTime = res.get("deceasedDateTime", LocalDateTime.class);
        this.address = res.getList("address", Address.class, null);
        this.telecom = res.getList("telecom", Telecom.class, null);
        this.contact = res.getList("contact", Contact.class, null);
        this.generalPractitioner = res.getList("generalPractitioner", GeneralPractitioner.class, null);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Identifier> getIdentifier() {
        return identifier;
    }

    public void setIdentifier(List<Identifier> identifier) {
        this.identifier = identifier;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<Name> getName() {
        return name;
    }

    public void setName(List<Name> name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDateTime getDeceasedDateTime() {
        return deceasedDateTime;
    }

    public void setDeceasedDateTime(LocalDateTime deceasedDateTime) {
        this.deceasedDateTime = deceasedDateTime;
    }

    public int getMultipleBirthInteger() {
        return multipleBirthInteger;
    }

    public void setMultipleBirthInteger(int multipleBirthInteger) {
        this.multipleBirthInteger = multipleBirthInteger;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public List<Telecom> getTelecom() {
        return telecom;
    }

    public void setTelecom(List<Telecom> telecom) {
        this.telecom = telecom;
    }

    public List<Contact> getContact() {
        return contact;
    }

    public void setContact(List<Contact> contact) {
        this.contact = contact;
    }

    public List<Relationship> getRelationships() {
        return relationships;
    }

    public void setRelationships(List<Relationship> relationships) {
        this.relationships = relationships;
    }

    public List<GeneralPractitioner> getGeneralPractitioner() {
        return generalPractitioner;
    }

    public void setGeneralPractitioner(List<GeneralPractitioner> generalPractitioner) {
        this.generalPractitioner = generalPractitioner;
    }

    public Document toDoc() {
        return new Document()
        .append("id", id)
        .append("identifier", Identifier.listToDoc(identifier))
        .append("meta", meta.toDoc())
        .append("name", Name.listToDoc(name))
        .append("gender", gender.toString())
        .append("birthDate", birthDate.toString())
        .append("deceasedDateTime", deceasedDateTime.toString())
        .append("multipleBirthInteger", multipleBirthInteger)
        .append("address", Address.listToDoc(address))
        .append("telecom", Telecom.listToDoc(telecom))
        .append("contact", Contact.listToDoc(contact))
        .append("relationship", Relationship.listToDoc(relationships))
        .append("generalPractitioner", GeneralPractitioner.listToDoc(generalPractitioner));
    }
}