package ru.stqa.pft.addressbook.tests;

import ru.stqa.pft.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("Goose", "Alekseevich", "Mr", "kanes173", "test1"), true);
    app.getContactHelper().saveContact();
    app.getNavigationHelper().goToHomePage();
  }
}
