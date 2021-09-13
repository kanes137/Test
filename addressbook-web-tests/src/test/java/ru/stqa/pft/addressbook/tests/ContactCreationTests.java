package ru.stqa.pft.addressbook.tests;

import ru.stqa.pft.addressbook.model.ContactData;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactCreationTests extends TestBase {

  @Test(enabled = false)
  public void testContactCreation() throws Exception {
    app.goTo().groupPage();
    if (! app.group().isThereAGroup()) {
      app.group().create(new GroupData("test1", "test2", "test3"));
    }
    app.getContactHelper().createContact(new ContactData("Goose", "Alekseevich", "Mr", "kanes173", "test1"), true);
  }
}
