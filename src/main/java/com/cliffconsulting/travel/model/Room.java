package com.cliffconsulting.travel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Room
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-15T21:16:59.955Z")

public class Room   {
  @JsonProperty("roomId")
  private Long roomId = null;

  @JsonProperty("hotelId")
  private Long hotelId = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("photoUrls")
  @Valid
  private List<String> photoUrls = new ArrayList<String>();

  @JsonProperty("startAvailDate")
  private LocalDate startAvailDate = null;

  @JsonProperty("endAvailDate")
  private LocalDate endAvailDate = null;

  @JsonProperty("maxGuests")
  private Integer maxGuests = null;

  public Room roomId(Long roomId) {
    this.roomId = roomId;
    return this;
  }

  /**
   * Get roomId
   * @return roomId
  **/
  @ApiModelProperty(value = "")


  public Long getRoomId() {
    return roomId;
  }

  public void setRoomId(Long roomId) {
    this.roomId = roomId;
  }

  public Room hotelId(Long hotelId) {
    this.hotelId = hotelId;
    return this;
  }

  /**
   * Get hotelId
   * @return hotelId
  **/
  @ApiModelProperty(value = "")


  public Long getHotelId() {
    return hotelId;
  }

  public void setHotelId(Long hotelId) {
    this.hotelId = hotelId;
  }

  public Room description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(example = "1 bed suite with King", required = true, value = "")
  @NotNull


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Room photoUrls(List<String> photoUrls) {
    this.photoUrls = photoUrls;
    return this;
  }

  public Room addPhotoUrlsItem(String photoUrlsItem) {
    this.photoUrls.add(photoUrlsItem);
    return this;
  }

  /**
   * Get photoUrls
   * @return photoUrls
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public List<String> getPhotoUrls() {
    return photoUrls;
  }

  public void setPhotoUrls(List<String> photoUrls) {
    this.photoUrls = photoUrls;
  }

  public Room startAvailDate(LocalDate startAvailDate) {
    this.startAvailDate = startAvailDate;
    return this;
  }

  /**
   * Get startAvailDate
   * @return startAvailDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public LocalDate getStartAvailDate() {
    return startAvailDate;
  }

  public void setStartAvailDate(LocalDate startAvailDate) {
    this.startAvailDate = startAvailDate;
  }

  public Room endAvailDate(LocalDate endAvailDate) {
    this.endAvailDate = endAvailDate;
    return this;
  }

  /**
   * Get endAvailDate
   * @return endAvailDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public LocalDate getEndAvailDate() {
    return endAvailDate;
  }

  public void setEndAvailDate(LocalDate endAvailDate) {
    this.endAvailDate = endAvailDate;
  }

  public Room maxGuests(Integer maxGuests) {
    this.maxGuests = maxGuests;
    return this;
  }

  /**
   * Get maxGuests
   * @return maxGuests
  **/
  @ApiModelProperty(value = "")


  public Integer getMaxGuests() {
    return maxGuests;
  }

  public void setMaxGuests(Integer maxGuests) {
    this.maxGuests = maxGuests;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Room room = (Room) o;
    return Objects.equals(this.roomId, room.roomId) &&
        Objects.equals(this.hotelId, room.hotelId) &&
        Objects.equals(this.description, room.description) &&
        Objects.equals(this.photoUrls, room.photoUrls) &&
        Objects.equals(this.startAvailDate, room.startAvailDate) &&
        Objects.equals(this.endAvailDate, room.endAvailDate) &&
        Objects.equals(this.maxGuests, room.maxGuests);
  }

  @Override
  public int hashCode() {
    return Objects.hash(roomId, hotelId, description, photoUrls, startAvailDate, endAvailDate, maxGuests);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Room {\n");
    
    sb.append("    roomId: ").append(toIndentedString(roomId)).append("\n");
    sb.append("    hotelId: ").append(toIndentedString(hotelId)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    photoUrls: ").append(toIndentedString(photoUrls)).append("\n");
    sb.append("    startAvailDate: ").append(toIndentedString(startAvailDate)).append("\n");
    sb.append("    endAvailDate: ").append(toIndentedString(endAvailDate)).append("\n");
    sb.append("    maxGuests: ").append(toIndentedString(maxGuests)).append("\n");
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

