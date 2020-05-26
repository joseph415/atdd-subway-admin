package wooteco.subway.admin.repository;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

import wooteco.subway.admin.domain.Line;
import wooteco.subway.admin.domain.LineStation;

@DataJdbcTest
class LineStationRepositoryTest {

    @Autowired
    private LineStationRepository lineStationRepository;
    @Autowired
    private LineRepository lineRepository;

    @Test
    void saveTest() {
        Line line = new Line("1호선", LocalTime.of(5, 30), LocalTime.of(23, 30), 10, "bg-gray-300");
        LineStation lineStation1 = new LineStation(1L, 2L, 3, 4);
        LineStation lineStation2 = new LineStation(2L, 3L, 3, 4);

        line.addLineStation(lineStation1);
        line.addLineStation(lineStation2);
        lineRepository.save(line);

        assertThat(lineStationRepository.findAllByLine(1L).size()).isEqualTo(2);
    }

}