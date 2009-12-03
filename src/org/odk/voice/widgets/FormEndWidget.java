package org.odk.voice.widgets;

import java.io.IOException;
import java.io.Writer;

import org.odk.voice.local.ResourceKeys;
import org.odk.voice.vxml.VxmlDocument;
import org.odk.voice.vxml.VxmlForm;
import org.odk.voice.vxml.VxmlUtils;

public class FormEndWidget extends WidgetBase {
 
  String formTitle;
  
  public FormEndWidget(String formTitle) {
    this.formTitle = formTitle;
  }
  
  @Override
  public void getPromptVxml(Writer out) throws IOException {
//    VxmlForm endForm = new VxmlForm("end", 
//        createPrompt(StringConstants.formEndPrompt(formTitle)),
//            "", "");
   
    VxmlForm endForm = new VxmlForm("main", createPrompt(
        String.format(getString(ResourceKeys.FORM_END), formTitle)),
        VxmlUtils.createGrammar(new String[]{"*"}, new String[]{""}),
        "Sorry, not yet implemented.<reprompt/>");
    new VxmlDocument(sessionid, endForm).write(out);
  }
}
