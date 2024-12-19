package comets;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class Asteroid {
    @JsonProperty("designation")
    private String designation;
    @JsonProperty("discovery_date")
    private LocalDateTime discoveryDate;
    @JsonProperty("h_mag")
    private Double magnitude;
    @JsonProperty("moid_au")
    private Double moidAu;
    @JsonProperty("orbit_class")
    private String orbitClass;

    public Asteroid() {
    }

    public String getDesignation() {
        return this.designation;
    }

    public LocalDateTime getDiscoveryDate() {
        return this.discoveryDate;
    }

    public Double getMagnitude() {
        return this.magnitude;
    }

    public Double getMoidAu() {
        return this.moidAu;
    }

    public String getOrbitClass() {
        return this.orbitClass;
    }

    public String toString() {
        String var10000 = this.designation;
        return "Asteroid{designation='" + var10000 + "', discoveryDate=" + String.valueOf(this.discoveryDate) + ", magnitude=" + this.magnitude + ", moidAu=" + this.moidAu + ", orbitClass='" + this.orbitClass + "'}";
    }
}
