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

    @Column(name = "id_external")
	private Integer id_external;

    @Column(name = "title")
	private String title;

    @Column(name = "overview")
	private String overview;

    @Column(name = "release_date")
	private String release_date;

	public int getIdMovie() {
        return id;
    }

    public void setIdMovie(int id) {
        this.id = id;
    }


	public int getExternalId() {
        return id_external;
    }

    public void setExternalId(int idExternal) {
        this.id_external = idExternal;
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
