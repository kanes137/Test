package ru.stqa.pft.addressbook.tests;

import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.sql.SQLOutput;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData()
              .withName("test1").withHeader("Модификация").withFooter("Модификация"));
    }
  }

  @Test
  public void testContactCreation() throws Exception {
    app.goTo().home();
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/TestPhoto.jpg");
    ContactData contact = new ContactData()
            .withFirstname("LOH").withMiddlename("Middlename").withLastname("Lastname")
            .withGroup("test1").withPhoto(photo);
    app.contact().create((contact),true);
    Contacts after = app.contact().all();
    assertEquals(after.size() - 1, before.size());
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

  @Test(enabled = false)
  public void testCurrentDir() {
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/TestPhoto.jpg");
    System.out.println(photo.getAbsolutePath());//Вернёт путь до директории с файлов
    System.out.println(photo.exists());//Проверка, что файл существует
  }
}