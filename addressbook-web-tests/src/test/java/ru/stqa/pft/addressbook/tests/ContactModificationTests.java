package ru.stqa.pft.addressbook.tests;

import model.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

  @Test
  public void testModificationContact() {
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("lol", "Aleks", "Ms", "vaniko"));
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().goToHomePage();
  }
}
