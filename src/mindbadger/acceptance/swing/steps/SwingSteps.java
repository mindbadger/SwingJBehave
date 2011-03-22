package mindbadger.acceptance.swing.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import mindbadger.acceptance.swing.SwingJBehaveUtilities;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class SwingSteps
{
  JFrame frame;
  SwingJBehaveUtilities utils = new SwingJBehaveUtilities ();
  
  @Given ("we have opened a frame called $frameName")
  public void openTheFrame (String frameName) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    frame = utils.instantiateFrame(frameName);
  }
  
  @When ("we click on button $buttonName")
  public void clickAButton (String buttonName) {
    JButton button = (JButton) utils.getChildNamed(frame, buttonName);
    button.doClick();
  }
  
  @Then ("field $fieldName contains text $expectedValue")
  public void checkField (String fieldName, String expectedValue) {
    JTextField field = (JTextField) utils.getChildNamed(frame, fieldName);
    assertThat(field.getText(), equalTo(expectedValue));
  }  
}
