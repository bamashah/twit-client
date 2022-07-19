import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName(value="application", alternate={"Application"})
    String application;

    @SerializedName(value="version", alternate={"Version"})
    String version;

    @SerializedName(value="uptime", alternate={"Uptime"})
    long uptime;

    @SerializedName(value="requestCount", alternate={"Request_Count"})
    long requestCount;

    @SerializedName(value="errorCount", alternate={"Error_Count"})
    long errorCount;

    @SerializedName(value="successCount", alternate={"Success_Count"})
    long successCount;

    double successRate;

    void calcSuccessRate() {
        successRate = (100.0 * successCount) / requestCount;
    }

    public String getApplication() {
        return application;
    }

    public String getVersion() {
        return version;
    }

    public double getSuccessRate() {
        return successRate;
    }
}






