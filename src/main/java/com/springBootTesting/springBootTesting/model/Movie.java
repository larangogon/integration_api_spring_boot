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

    @Column(name = "external_id", nullable = false)
	private Integer external_id;

    @Column(name = "title", nullable = false, length = 255)
	private String title;

    @Column(name = "overview", nullable = false, length = 525)
	private String overview;

    @Column(name = "release_date", nullable = false)
	private String release_date;

	public Movie(Integer id, String title, String releaseDate, String overview) {
        super();
        this.external_id = id;
        this.title =  title;
        this.overview = overview;
        this.release_date = releaseDate;

    }

    public Integer getIdMovie() {
        return id;
    }

    public void setIdMovie(Integer id) {
        this.id = id;
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
        return release_date;
    }

    public void setReleaseDate(String releaseDate) {
        this.release_date = releaseDate;
    }
}
