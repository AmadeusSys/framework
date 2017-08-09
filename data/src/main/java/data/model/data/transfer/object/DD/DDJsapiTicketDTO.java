package data.model.data.transfer.object.DD;

/**
 * Created by TY on 2017/6/18.
 */
public class DDJsapiTicketDTO extends DDBaseDTO {

    private String ticket;

    private Long expires_in;

    public String getTicket() {
        return ticket;
    }
    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Long expires_in) {
        this.expires_in = expires_in;
    }

}
