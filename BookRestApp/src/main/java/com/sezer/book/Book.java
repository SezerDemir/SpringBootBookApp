package com.sezer.book;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.extern.jackson.Jacksonized;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "isbn", nullable = false, length = 128)
	private String isbn;
	@Column(name = "url", nullable = false, length = 128)
	@Length(min = 5, max = 128)
	@JsonProperty("url")
	private String url;
	@Column(name = "title", nullable = false, length = 128)
	@JsonProperty("title")
	private String title;
	@Column(name = "subtitle", length = 128)
	@JsonProperty("subtitle")
	private String subtitle;
	@Column(name = "publish_date" , nullable = false, updatable = false)
    @CreationTimestamp
	private LocalDate publishDate;
	@Column(name = "sell_count", nullable = false)
	private int sellCount;
}
