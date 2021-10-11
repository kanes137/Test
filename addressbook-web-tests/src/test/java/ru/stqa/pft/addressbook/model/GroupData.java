package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //Аннотации @Entity и @Table(name = "group_list") объявляет класс GroupData привязанным к базе (Hibernate)
@Table(name = "group_list") //Сопоставить название таблицы с Entity необходимо для Hibernate
public class GroupData {
  @Id //Атрибут id используется как идентификатор, по этому ему присваивается аннотация @Id (Hibernate)
  @Column(name = "group_id") //с помощью аннотации @Column, атрибут id привязывается к столбцу БД group_id (Hibernate)
  private int id = Integer.MAX_VALUE;
  @Expose
  @Column(name = "group_name") //с помощью аннотации @Column, атрибут name привязывается к столбцу БД group_name (Hibernate)
  private String name;
  @Expose
  @Column(name = "group_header") //с помощью аннотации @Column, атрибут header привязывается к столбцу БД group_header (Hibernate)
  @Type(type = "text") //Аннотация описания типа для Hibernate при ошибке "wrong column type encountered in column [group_footer]"
  private String header;
  @Expose
  @Column(name = "group_footer") //с помощью аннотации @Column, атрибут footer привязывается к столбцу БД group_footer (Hibernate)
  @Type(type = "text") //Аннотация описания типа для Hibernate при ошибке "wrong column type encountered in column [group_footer]"
  private String footer;
  /*
  //если бы название столбца БД совпадало с названием атрибута, то необхододимость в привязке отпала бы,
  //т.к. Hibernate сопоставил название столбца в БД и атрибут автоматически
   */

  public String getName() {
    return name;
  }

  public String getHeader() {
    return header;
  }

  public String getFooter() {
    return footer;
  }

  public int getId() {
    return id;
  }

  public GroupData withId(int id) {
    this.id = id;
    return this;
  }

  public GroupData withName(String name) {
    this.name = name;
    return this;
  }

  public GroupData withHeader(String header) {
    this.header = header;
    return this;
  }

  public GroupData withFooter(String footer) {
    this.footer = footer;
    return this;
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
  }

  @Override //Метод сравнениия
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupData groupData = (GroupData) o;

    if (id != groupData.id) return false;
    return name != null ? name.equals(groupData.name) : groupData.name == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }
}
