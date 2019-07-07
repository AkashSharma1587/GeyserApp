package com.app.subscription.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "subscription")
@NamedQuery(name = "Subscription.findAll", query = "select x from Subscription x")
public class Subscription {
    @Id
    @GeneratedValue
    int id;

    String userId;

    DateTime startTime;

    DateTime endTime;
}
