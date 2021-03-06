/*
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2014, Telestax Inc and individual contributors
 * by the @authors tag.
 *
 * This program is free software: you can redistribute it and/or modify
 * under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package org.restcomm.connect.rvd.model.steps.ussdsay;

import org.restcomm.connect.rvd.exceptions.InterpreterException;
import org.restcomm.connect.rvd.interpreter.Interpreter;
import org.restcomm.connect.rvd.model.client.Step;

/**
 * @author otsakir@gmail.com - Orestis Tsakiridis
 */
public class UssdSayStep extends Step {

    String text;

    public static UssdSayStep createDefault(String name, String phrase) {
        UssdSayStep step = new UssdSayStep();
        step.setName(name);
        step.setLabel("USSD Message");
        step.setKind("ussdSay");
        step.setTitle("USSD Message");
        step.setText(phrase);

        return step;
    }

    public UssdSayStep() {
        // TODO Auto-generated constructor stub
    }


    public String getText() {
        return text;
    }


    public void setText(String text) {
        this.text = text;
    }

    @Override
    public UssdSayRcml render(Interpreter interpreter) throws InterpreterException {
        UssdSayRcml rcmlModel = new UssdSayRcml();
        rcmlModel.text = interpreter.populateVariables(getText());

        return rcmlModel;
    }
}
