package pl.pasiekaksiazek.web.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SiteResponseJson {

    @JsonCreator
    public SiteResponseJson(@JsonProperty("code") String code,
                            @JsonProperty("msg") String msg,
                            @JsonProperty("data") DataModel data){

        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private String code;

    private String msg;

    private DataModel data;
}
