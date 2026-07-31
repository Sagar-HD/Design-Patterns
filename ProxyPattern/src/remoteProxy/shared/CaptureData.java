package remoteProxy.shared;

import java.io.Serializable;
import java.time.LocalDateTime;
//adding in shared to match package name
public class CaptureData implements Serializable {
    private LocalDateTime timestamp;
    private String data;
    private String location;


    public CaptureData(LocalDateTime timestamp, String data, String location) {
        this.timestamp = timestamp;
        this.data = data;
        this.location=location;
    }

    public String getData() {
        return data;
    }

    public String getLocation() {
        return location;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
