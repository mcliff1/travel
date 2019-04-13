package com.cliffconsulting.travel.model;

import java.util.Objects;
import com.cliffconsulting.travel.model.ReservationGuest;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Reservation
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-15T21:16:59.955Z")

public class Reservation   {
  @JsonProperty("reservationId")
  private Long reservationId = null;

  @JsonProperty("roomId")
  private Long roomId = null;

  @JsonProperty("startDate")
  private LocalDate startDate = null;

  @JsonProperty("endDate")
  private LocalDate endDate = null;

  @JsonProperty("guests")
  @Valid
  private List<ReservationGuest> guests = new ArrayList<ReservationGuest>();

  public Reservation reservationId(Long reservationId) {
    this.reservationId = reservationId;
    return this;
  }

  /**
   * Get reservationId
   * @return reservationId
  **/
  @ApiModelProperty(value = "")


  public Long getReservationId() {
    return reservationId;
  }

  public void setReservationId(Long reservationId) {
    this.reservationId = reservationId;
  }

  public Reservation roomId(Long roomId) {
    this.roomId = roomId;
    return this;
  }

  /**
   * Get roomId
   * @return roomId
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Long getRoomId() {
    return roomId;
  }

  public void setRoomId(Long roomId) {
    this.roomId = roomId;
  }

  public Reservation startDate(LocalDate startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Get startDate
   * @return startDate
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public Reservation endDate(LocalDate endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * Get endDate
   * @return endDate
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public Reservation guests(List<ReservationGuest> guests) {
    this.guests = guests;
    return this;
  }

  public Reservation addGuestsItem(ReservationGuest guestsItem) {
    this.guests.add(guestsItem);
    return this;
  }

  /**
   * Get guests
   * @return guests
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public List<ReservationGuest> getGuests() {
    return guests;
  }

  public void setGuests(List<ReservationGuest> guests) {
    this.guests = guests;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Reservation reservation = (Reservation) o;
    return Objects.equals(this.reservationId, reservation.reservationId) &&
        Objects.equals(this.roomId, reservation.roomId) &&
        Objects.equals(this.startDate, reservation.startDate) &&
        Objects.equals(this.endDate, reservation.endDate) &&
        Objects.equals(this.guests, reservation.guests);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reservationId, roomId, startDate, endDate, guests);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Reservation {\n");
    
    sb.append("    reservationId: ").append(toIndentedString(reservationId)).append("\n");
    sb.append("    roomId: ").append(toIndentedString(roomId)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    guests: ").append(toIndentedString(guests)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

