package wooteco.subway.admin.domain;

import java.util.Objects;

public class LineStation {
    private static final long START_STATION = -1L;
    private Long stationId;
    private Long preStationId;
    private int distance;
    private int duration;

    public LineStation() {
    }

    public LineStation(Long preStationId, Long stationId, int distance, int duration) {
        this.stationId = stationId;
        this.distance = distance;
        this.duration = duration;
        if (Objects.nonNull(preStationId)) {
            this.preStationId = preStationId;
            return;
        }
        this.preStationId = START_STATION;
    }

    public Long getPreStationId() {
        return preStationId;
    }

    public Long getStationId() {
        return stationId;
    }

    public int getDistance() {
        return distance;
    }

    public int getDuration() {
        return duration;
    }

    public void updatePreLineStation(Long preStationId) {
        this.preStationId = preStationId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getStationId());
    }

    @Override
    public boolean equals(Object obj) {
        return ((LineStation)obj).getStationId().equals(this.stationId);
    }
}
