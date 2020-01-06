package pl.pasiekaksiazek.web.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DataModel {

    @JsonCreator
    public DataModel(@JsonProperty("moreLink") String moreLink,
                     @JsonProperty("content") String content,
                     @JsonProperty("count") String count,
                     @JsonProperty("left") Integer left){

        this.moreLink = moreLink;
        this.content = content;
        this.count = count;
        this.left = left;

    }

    private String moreLink;

    private String content;

    private String count;

    private Integer left;
}
