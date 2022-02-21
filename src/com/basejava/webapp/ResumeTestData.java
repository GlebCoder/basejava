package com.basejava.webapp;

import com.basejava.webapp.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume kislin = new Resume("Григорий Кислин");
        kislin = makeResume(kislin.getUuid(), kislin.getFullName());
        printResume(kislin);

    }

    private static void printResume(Resume resume) {
        System.out.println(resume.getFullName().toUpperCase());
        for (Map.Entry<ContactType, String> contactEntry : resume.getContacts().entrySet()) {
            System.out.println(contactEntry.getKey() + ": " + contactEntry.getValue());
        }
        for (Map.Entry<SectionType, Section> entry : resume.getSections().entrySet()) {
            System.out.println();
            System.out.println(entry.getKey().getType());
            System.out.println(entry.getValue().toString());
        }
    }

    public static Resume makeResume(String uuid, String fullName) {
        Resume resume = new Resume(uuid, fullName);

        resume.addContact(ContactType.PHONE, "+7(921) 855-0482");
        resume.addContact(ContactType.SKYPE, "grigory.kislin");
        resume.addContact(ContactType.EMAIL, "gkislin@yandex.ru");
        resume.addContact(ContactType.LINKEDIN, "Профиль LinkedIn");
        resume.addContact(ContactType.GITHUB, "Профиль GitHub");
        resume.addContact(ContactType.STACKOVERFLOW, "Профиль Stackoverflow");
        resume.addContact(ContactType.HOME_PAGE, "Домашняя страница");

        Section objective = new PlainSection("Ведущий стажировок и корпоративного обучения по Java Web"
                + " и Enterprise технологиям");
        resume.addSection(SectionType.OBJECTIVE, objective);

        Section personal = new PlainSection("Аналитический склад ума, сильная логика, креативность, "
                + "инициативность. Пурист кода и архитектуры.");
        resume.addSection(SectionType.PERSONAL, personal);

        List<String> allAchievements = new ArrayList<>();
        Section achievements = new BulletedListSection(allAchievements);
        resume.addSection(SectionType.ACHIEVEMENTS, achievements);
        allAchievements.add("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", "
                + "\"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). "
                + "Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. "
                + "Более 1000 выпускников.");
        allAchievements.add("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike."
                + " Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");
        allAchievements.add("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM."
                + " Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке:"
                + " Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей,"
                + " интеграция CIFS/SMB java сервера.");
        allAchievements.add("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA,"
                + " Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.");
        allAchievements.add("Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов"
                + " (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о"
                + " состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования"
                + " и мониторинга системы по JMX (Jython/ Django).");
        allAchievements.add("Реализация протоколов по приему платежей всех основных платежных системы России"
                + " (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");

        List<String> allQualifications = new ArrayList<>();
        Section qualifications = new BulletedListSection(allQualifications);
        resume.addSection(SectionType.QUALIFICATIONS, qualifications);
        allQualifications.add("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        allQualifications.add("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        allQualifications.add("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle,");
        allQualifications.add("MySQL, SQLite, MS SQL, HSQLDB");
        allQualifications.add("Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy,");
        allQualifications.add("XML/XSD/XSLT, SQL, C/C++, Unix shell scripts,");
        allQualifications.add("Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis,"
                + " Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice,"
                + " GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit,"
                + " Selenium (htmlelements).");
        allQualifications.add("Python: Django.");
        allQualifications.add("JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js");
        allQualifications.add("Scala: SBT, Play2, Specs2, Anorm, Spray, Akka");
        allQualifications.add("Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX,"
                + " DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP,"
                + " OAuth1, OAuth2, JWT.\n");
        allQualifications.add("Инструменты: Maven + plugin development, Gradle, настройка Ngnix,");
        allQualifications.add("администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios,"
                + " iReport, OpenCmis, Bonita, pgBouncer.");
        allQualifications.add("Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования,"
                + " архитектурных шаблонов, UML, функционального программирования");
        allQualifications.add("Родной русский, английский \"upper intermediate\"");

        List<Company> allJobs = new ArrayList<>();
        Section experiences = new CompanySection(allJobs);
        resume.addSection(SectionType.EXPERIENCE, experiences);

        Position javaOnlineProjectsPoition1 = new Position(LocalDate.of(2013, 10, 01),
                LocalDate.now(), "Автор проекта.",
                "Создание, организация и проведение Java онлайн проектов и стажировок.");
        List<Position> javaOnlineProjectsPoitions = new ArrayList<>();
        javaOnlineProjectsPoitions.add(javaOnlineProjectsPoition1);
        Company javaOnlineProjects = new Company("Java Online Projects", javaOnlineProjectsPoitions);
        allJobs.add(javaOnlineProjects);

        Position wrikePosition1 = new Position(LocalDate.of(2014, 10, 02), LocalDate.of(2016, 01, 31),
                "Старший разработчик (backend)",
                "Проектирование и разработка онлайн платформы управления проектами Wrike"
                        + " (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis)."
                        + " Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.");
        List<Position> wrikePositions = new ArrayList<>();
        wrikePositions.add(wrikePosition1);
        Company wrike = new Company("Wrike", wrikePositions);
        allJobs.add(wrike);

        String jobDescriptionRit = "Организация процесса разработки системы ERP для разных окружений:"
                + " релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway),"
                + " конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы."
                + " Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения"
                + " (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера"
                + " документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC,"
                + " Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting"
                + " via ssh tunnels, PL/Python";
        Position ritCenterPosition1 = new Position(LocalDate.of(2012, 04, 01),
                LocalDate.of(2014, 10, 01), "Java архитектор", jobDescriptionRit);
        List<Position> ritCenterPositions = new ArrayList<>();
        ritCenterPositions.add(ritCenterPosition1);
        Company ritCenter = new Company("RIT Center", ritCenterPositions);
        allJobs.add(ritCenter);

        String jobDescriptionLuxoft = "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC,"
                + " SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM."
                + " Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области"
                + " алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5.";
        Position luxoftPosition1 = new Position(LocalDate.of(2010, 12, 02),
                LocalDate.of(2014, 04, 30), "Ведущий программист", jobDescriptionLuxoft);
        List<Position> luxoftPositions = new ArrayList<>();
        luxoftPositions.add(luxoftPosition1);
        Company luxoft = new Company("Luxoft (Deutsche Bank)", luxoftPositions);
        allJobs.add(luxoft);

        String jobDescriptionYota = "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\""
                + " (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2)."
                + " Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента"
                + " (Python/ Jython, Django, ExtJS)";
        Position yotaPosition1 = new Position(LocalDate.of(2008, 06, 02),
                LocalDate.of(2010, 12, 01),
                "Ведущий специалист", jobDescriptionYota);
        List<Position> yotaPositions = new ArrayList<>();
        yotaPositions.add(yotaPosition1);
        Company yota = new Company("Yota", yotaPositions);
        allJobs.add(yota);

        String jobDescriptionEnkata = "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0,"
                + " Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining).";
        Position enkataPosition1 = new Position(LocalDate.of(2007, 03, 02),
                LocalDate.of(2008, 06, 01), "Разработчик ПО", jobDescriptionEnkata);
        List<Position> enkataPositions = new ArrayList<>();
        enkataPositions.add(enkataPosition1);
        Company enkata = new Company("Enkata", enkataPositions);
        allJobs.add(enkata);

        String jobDescriptionSiemens = "Разработка информационной модели, проектирование интерфейсов, реализация и"
                + " отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix).";
        Position siemensPosition1 = new Position(LocalDate.of(2005, 01, 02),
                LocalDate.of(2007, 02, 28),
                "Разработчик ПО", jobDescriptionSiemens);
        List<Position> siemensPositions = new ArrayList<>();
        siemensPositions.add(siemensPosition1);
        Company siemens = new Company("Siemens AG", siemensPositions);
        allJobs.add(siemens);

        String jobDescriptionAlcatel = "Тестирование, отладка, внедрение ПО цифровой телефонной станции"
                + " Alcatel 1000 S12 (CHILL, ASM).";
        Position alcatelPosition1 = new Position(LocalDate.of(1997, 9, 02),
                LocalDate.of(2005, 01, 01),
                "Инженер по аппаратному и программному тестированию", jobDescriptionAlcatel);
        List<Position> alcatelPositions = new ArrayList<>();
        alcatelPositions.add(alcatelPosition1);
        Company alcatel = new Company("Alcatel", alcatelPositions);
        allJobs.add(alcatel);

        List<Company> allSchools = new ArrayList<>();
        Section education = new CompanySection(allSchools);
        resume.addSection(SectionType.EDUCATION, education);

        Position courseraPosition1 = new Position(LocalDate.of(2013, 03, 01),
                LocalDate.of(2013, 05, 01),
                "", "Functional Programming Principles in Scala\" by Martin Odersky");
        List<Position> courseraPositions = new ArrayList<>();
        courseraPositions.add(courseraPosition1);
        Company coursera = new Company("Coursera", courseraPositions);
        allSchools.add(coursera);

        Position luxoftSchoolPosition1 = new Position(LocalDate.of(2011, 03, 01),
                LocalDate.of(2011, 04, 01), "",
                "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"");
        List<Position> luxoftSchoolPositions = new ArrayList<>();
        luxoftSchoolPositions.add(luxoftSchoolPosition1);
        Company luxoftSchool = new Company("Luxoft", luxoftSchoolPositions);
        allSchools.add(luxoftSchool);

        Position siemensSchoolPosition1 = new Position(LocalDate.of(2005, 01, 01),
                LocalDate.of(2005, 04, 01), "",
                "3 месяца обучения мобильным IN сетям (Берлин)");
        List<Position> siemensSchoolPositions = new ArrayList<>();
        siemensSchoolPositions.add(siemensSchoolPosition1);
        Company siemensSchool = new Company("Siemens AG", siemensSchoolPositions);
        allSchools.add(siemensSchool);

        Position alcatelSchoolPosition1 = new Position(LocalDate.of(1997, 9, 01),
                LocalDate.of(1998, 3, 01), "",
                "6 месяцев обучения цифровым телефонным сетям (Москва)");
        List<Position> alcatelSchoolPositions = new ArrayList<>();
        alcatelSchoolPositions.add(alcatelSchoolPosition1);
        Company alcatelSchool = new Company("Alcatel", alcatelSchoolPositions);
        allSchools.add(alcatelSchool);

        Position universityPosition1 = new Position(LocalDate.of(1993, 9, 01),
                LocalDate.of(1996, 7, 01), "",
                "Аспирантура (программист С, С++)");
        Position universityPosition2 = new Position(LocalDate.of(1987, 9, 01),
                LocalDate.of(1993, 7, 01), "",
                "Инженер (программист Fortran, C)");
        List<Position> universityPositions = new ArrayList<>();
        universityPositions.add(universityPosition1);
        universityPositions.add(universityPosition2);
        Company university = new Company("Санкт-Петербургский национальный"
                + " исследовательский университет информационных технологий, механики и оптики",
                universityPositions);
        allSchools.add(university);

        Position schoolPosition1 = new Position(LocalDate.of(1984, 9, 01),
                LocalDate.of(1987, 6, 01), "",
                "Закончил с отличием");
        List<Position> schoolPositions = new ArrayList<>();
        schoolPositions.add(schoolPosition1);
        Company school = new Company("Заочная физико-техническая школа при МФТИ", schoolPositions);
        allSchools.add(school);

        return resume;
    }
}
