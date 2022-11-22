package com.booking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="booking")
public class Booking implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="city_id")
    private UUID movieId;
	@NotNull
	@Column(name="movieName")
	private String movieName;
	@NotNull
	@Column(name="userId")
    private String userId;
	@NotNull
	@Column(name="userName")
    private String userName;

	@Column(name="city_area")
	private UUID screenId;

}
