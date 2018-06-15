package ru.yandex.sashanc.service;

import ru.yandex.sashanc.pojo.Lesson;

import java.util.List;

public interface ILessonService {
    List<Lesson> getLessonsByDiscipline(int disciplineId);
}
