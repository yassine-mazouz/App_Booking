package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client")
    private Client client;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "users")
    private Users users;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hotel")
    private Hotel hotel;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room")
    private Room room;

    @Column(name = "nombre", nullable = true)
    private int name;

    @Column(name = "night", nullable = true)
    private int night;

    @Column(name = "date_debut", nullable = true)
    private String date_debut;

    @Column(name = "date_fin", nullable = true)
    private String date_fin;

    @Column(name = "invite", nullable = true)
    private int invite;


    @Column(name = "booking_time", nullable = true)
    private String booking_time;
    @Column(name = "deleted", nullable = true)
    private String deleted;
    @Column(name = "etat", nullable = true)
    private String etat;
    @Column(name = "prix", nullable = true)
    private Double prix;
    @Column(name = "titre", nullable = true)
    private String titre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBooking_time() {
        return booking_time;
    }

    public void setBooking_time(String booking_time) {
        this.booking_time = booking_time;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }


    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getNight() {
        return night;
    }

    public void setNight(int night) {
        this.night = night;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public int getInvite() {
        return invite;
    }

    public void setInvite(int invite) {
        this.invite = invite;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}