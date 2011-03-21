package mjf.acceptance.swing;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JFrame;

public class SwingJBehaveUtilities
{
  @SuppressWarnings("unchecked")
  public JFrame instantiateFrame (String frameName) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    Class<JFrame> myClass  = (Class<JFrame>) Class.forName(frameName);
    Object object = myClass.newInstance();

    JFrame frame = (JFrame)object;
    frame.setVisible(true);

    return frame;
  }
  
  
  public Component getChildNamed(Component parent, String name) {
    if (name.equals(parent.getName())) { return parent; }

    if (parent instanceof Container) {
       Component[] children = ((Container)parent).getComponents();

       for (int i = 0; i < children.length; ++i) {
          Component child = getChildNamed(children[i], name);
          if (child != null) { return child; }
       }
    }

    return null;
  }
}
