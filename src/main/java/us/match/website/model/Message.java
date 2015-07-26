package us.match.website.model;

/**
 * Created by WH on 2015/7/23.
 */
public class Message {
    int infoId;
    int senderId;
    int receiverId;
    String sendName;
    String receiverName;
    String content;
    String time;

    public int getInfoId(){return infoId;}

    public void setInfoId(int infoId){this.infoId=infoId;}

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public String getSendName() {
        return sendName;
    }

    public void setSendName(String sendName) {
        this.sendName = sendName;
    }
}
