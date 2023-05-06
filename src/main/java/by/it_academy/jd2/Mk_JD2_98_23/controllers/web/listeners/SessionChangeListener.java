package by.it_academy.jd2.Mk_JD2_98_23.controllers.web.listeners;

import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

public class SessionChangeListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("new attribute Added");
    }

}
