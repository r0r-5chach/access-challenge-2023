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
    private List<Identifier> identifiers;
    private Meta meta;
    private List<Name> names;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDateTime deceasedDateTime;
    private int multipleBirthInteger;
    private List<Address> addresses;
    private List<Telecom> telecoms;
    private List<Contact> contacts;
    private List<Relationship> relationships;
    private List<GeneralPractitioner> generalPractitioners;

    public Patient(String id, List<Identifier> identifiers, Meta meta, List<Name> names, Gender gender,
            LocalDate birthDate, LocalDateTime deceasedDateTime, int multipleBirthInteger, List<Address> addresses,
            List<Telecom> telecoms, List<Contact> contacts, List<GeneralPractitioner> generalPractitioners) {
        this.id = id;
        this.identifiers = identifiers;
        this.meta = meta;
        this.names = names;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deceasedDateTime = deceasedDateTime;
        this.multipleBirthInteger = multipleBirthInteger;
        this.addresses = addresses;
        this.telecoms = telecoms;
        this.contacts = contacts;
        this.generalPractitioners = generalPractitioners;
    }

    public Patient(Document res) {
        //TODO: Destructure doc into patient attrs
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Identifier> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(List<Identifier> identifiers) {
        this.identifiers = identifiers;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
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

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Telecom> getTelecoms() {
        return telecoms;
    }

    public void setTelecoms(List<Telecom> telecoms) {
        this.telecoms = telecoms;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Relationship> getRelationships() {
        return relationships;
    }

    public void setRelationships(List<Relationship> relationships) {
        this.relationships = relationships;
    }

    public List<GeneralPractitioner> getGeneralPractitioners() {
        return generalPractitioners;
    }

    public void setGeneralPractitioners(List<GeneralPractitioner> generalPractitioners) {
        this.generalPractitioners = generalPractitioners;
    }
}