package org.odk.voice.widgets;

import java.io.IOException;
import java.io.Writer;

import org.javarosa.core.model.data.IAnswerData;
import org.javarosa.core.model.data.IntegerData;
import org.odk.voice.constants.StringConstants;
import org.odk.voice.storage.MultiPartFormData;
import org.odk.voice.vxml.VxmlDocument;
import org.odk.voice.vxml.VxmlField;
import org.odk.voice.vxml.VxmlForm;
import org.odk.voice.vxml.VxmlSection;
import org.odk.voice.xform.PromptElement;

public class InfoWidget extends QuestionWidget {
  
  public InfoWidget(PromptElement p) {
    super(p);
  }
  
  public void getPromptVxml(Writer out) throws IOException{

      
      VxmlSection infoSection = new VxmlSection("<block>" + 
          createPrompt(prompt.getQuestionText()) + 
          "</block>");
      
      VxmlField actionField = new VxmlField("action", 
          createPrompt(StringConstants.infoConfirmation),
          actionGrammar,
          actionFilled(false));

      VxmlForm mainForm = new VxmlForm("main", infoSection, actionField);
      
      VxmlDocument d = new VxmlDocument(sessionid, mainForm);
      d.write(out);
  }
    
  @Override
  public IAnswerData getAnswer(String stringData, MultiPartFormData binaryData)
      throws IllegalArgumentException {
    return null;
  }

}