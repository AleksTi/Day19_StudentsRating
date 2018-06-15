package ru.yandex.sashanc.service;

import org.apache.log4j.Logger;
import ru.yandex.sashanc.data.dao.DisciplineDaoImpl;
import ru.yandex.sashanc.data.dao.IDisciplineDao;
import ru.yandex.sashanc.pojo.Discipline;

import java.sql.SQLException;
import java.util.List;

public class DisciplineServiceImpl implements IDisciplineService {
    private static final Logger logger = Logger.getLogger(DisciplineServiceImpl.class);

    @Override
    public List<Discipline> getDisciplines() {
        IDisciplineDao disciplineDao = new DisciplineDaoImpl();
        try {
            return disciplineDao.getDisciplines();
        } catch (SQLException e) {
            logger.info("Catch block of method \"DisciplineServiceImpl.getDisciplines()\" have done" + e);
        }
        return null;
    }
}
