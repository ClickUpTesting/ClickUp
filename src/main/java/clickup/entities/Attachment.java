/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package clickup.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Attachment {
    private String id;
    private String version;
    private String date;
    private String title;
    private String extension;
    @JsonProperty("thumbnail_small")
    private String thumbnailSmall;
    @JsonProperty("thumbnail_medium")
    private String thumbnailMedium;
    @JsonProperty("thumbnail_large")
    private String thumbnailLarge;
    private String url;
    @JsonProperty("url_w_query")
    private String urlWQuery;
    @JsonProperty("url_w_host")
    private String urlWHost;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getThumbnailSmall() {
        return thumbnailSmall;
    }

    public void setThumbnailSmall(String thumbnailSmall) {
        this.thumbnailSmall = thumbnailSmall;
    }

    public String getThumbnailMedium() {
        return thumbnailMedium;
    }

    public void setThumbnailMedium(String thumbnailMedium) {
        this.thumbnailMedium = thumbnailMedium;
    }

    public String getThumbnailLarge() {
        return thumbnailLarge;
    }

    public void setThumbnailLarge(String thumbnailLarge) {
        this.thumbnailLarge = thumbnailLarge;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlWQuery() {
        return urlWQuery;
    }

    public void setUrlWQuery(String urlWQuery) {
        this.urlWQuery = urlWQuery;
    }

    public String getUrlWHost() {
        return urlWHost;
    }

    public void setUrlWHost(String urlWHost) {
        this.urlWHost = urlWHost;
    }
}
