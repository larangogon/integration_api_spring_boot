package com.springBootTesting.springBootTesting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

    @Column(name = "externalId", nullable = false)
	private Integer externalId;

    @Column(name = "title", nullable = false, length = 255)
	private String title;

    @Column(name = "overview", nullable = false, length = 525)
	private String overview;

    @Column(name = "releaseDate", nullable = false)
	private String releaseDate;

    public Movie() {}

	public Movie(Integer externalId, String title, String releaseDate, String overview) {
        super();
        this.externalId = externalId;
        this.title = title;
        this.overview = overview;
        this.releaseDate = releaseDate;
    }

    public Integer getIdMovie() {
        return id;
    }

    public void setIdMovie(Integer id) {
        this.id = id;
    }

	public Integer getExternalId() {
        return externalId;
    }

    public void setExternalId(Integer externalId) {
        this.externalId = externalId;
    }

	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

	public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

	public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
