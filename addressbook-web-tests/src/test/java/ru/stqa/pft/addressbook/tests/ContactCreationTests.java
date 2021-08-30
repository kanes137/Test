package ru.stqa.pft.addressbook.tests;

import model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("Goose", "Alekseevich", "Mr", "kanes173"));
    app.getContactHelper().saveContact();
    app.getNavigationHelper().goToHomePage();
  }
}
