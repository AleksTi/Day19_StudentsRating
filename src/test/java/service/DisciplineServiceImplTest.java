package service;

import org.junit.Before;
import org.junit.Test;
import ru.yandex.sashanc.service.DisciplineServiceImpl;
import ru.yandex.sashanc.service.IDisciplineService;

public class DisciplineServiceImplTest {
    private IDisciplineService disciplineService;

    @Before
    public void before() {
        this.disciplineService = new DisciplineServiceImpl();
    }

    @Test
    public void getDisciplinesTest() {

    }
}
