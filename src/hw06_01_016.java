import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;
import java.util.ArrayList;

public class hw06_01_016 {
    public hw06_01_016()
    {
        this.butt_05_scope();
    }
    JPanel pnlFromRadioButton;
    public static final String[] BUTTON_TEXTS = {"1. Juozas", "2. Bytnikas", "3. Budulis", "4. Budulajus"};
    public static String[] BUTTON_TEXTS_jk = new String[40];
    public static ArrayList<String> actItemhw06_01_016 = new ArrayList<String>();
    public static ArrayList<Boolean> actStatushw06_01_016 = new ArrayList<Boolean>();
    public static int Number = 0;

    public class activityBool{
        private String activityName;
        private boolean activityStatus;
    }
    private static void JPanel1() {
        JTextField tcw06_01_001_f01 = new JTextField(20);
        tcw06_01_001_f01.setText("Insert the activities list NAME here");
        JTextField tcw06_01_001_f02 = new JTextField(20);
        tcw06_01_001_f02.setText("Insert the activity NAME here");
        int arrayDim = 40;
        int arrhw06_01_001_doneIn01[] = new int[40];
        for (int z = 0; z < arrayDim; z++) {
            arrhw06_01_001_doneIn01[z] = 0;
        }
        final ButtonGroup btnGroup = new ButtonGroup();
        JPanel panel;
        JPanel panelButt= new JPanel();
        JPanel pnlFromRadioButton;
        pnlFromRadioButton = new JPanel();
        final JTextField selectionField = new JTextField();
        panel = new JPanel(new GridLayout(0, 1));
        JButton buttonSaveListName = new JButton(new AbstractAction("Save the activities list NAME"){
            public void actionPerformed(ActionEvent arg0) {
                final ButtonGroup btnGroup = new ButtonGroup();
                JPanel panel;
                JPanel panelButt= new JPanel();
                JPanel pnlFromRadioButton;
                pnlFromRadioButton = new JPanel();
                final JTextField selectionField = new JTextField();
                panel = new JPanel(new GridLayout(0, 1));
                String listName = tcw06_01_001_f01.getText();
                JButton buttonSaveListItem = new JButton(new AbstractAction("Save the ACTIVITY into the activities list of "+listName){
                    public void actionPerformed(ActionEvent arg0) {
                        Number++;
                        String listItem = tcw06_01_001_f02.getText();
                        BUTTON_TEXTS[0]=listItem;
                        actItemhw06_01_016.add(Number + ". " + listItem);
                        actStatushw06_01_016.add(false);
                    }
                });
                JButton buttonSaveList = new JButton(new AbstractAction("Save the LIST as the activities list of "+listName){
                    public void actionPerformed(ActionEvent arg0) {
                        final ButtonGroup btnGroup = new ButtonGroup();
                        JPanel panel;
                        JPanel panelButt= new JPanel();
                        JPanel pnlFromRadioButton;
                        pnlFromRadioButton = new JPanel();
                        final JTextField selectionField = new JTextField();
                        panel = new JPanel(new GridLayout(0, 1));
                        String listName = tcw06_01_001_f01.getText();
                        JButton buttonChooseFullList = new JButton(new AbstractAction("Get to choose the FULL list of "+ listName){
                            public void actionPerformed(ActionEvent arg0) {
                                panel.remove(pnlFromRadioButton);
                                pnlFromRadioButton.removeAll();
                                panel.revalidate();
                                panel.repaint();
                                String listName = tcw06_01_001_f01.getText();
                                pnlFromRadioButton.setBorder(BorderFactory.createTitledBorder("FULL List of activities from the list of "+ listName));
                                for (String btnText : actItemhw06_01_016) {
                                    JRadioButton radioBtn = new JRadioButton(btnText);
                                    radioBtn.setActionCommand(btnText);
                                    btnGroup.add(radioBtn);
                                    pnlFromRadioButton.add(radioBtn);
                                }
                                panel.add(pnlFromRadioButton);
                            }
                        });
                        JButton buttonChoosePlanList = new JButton(new AbstractAction("Get to Choose UNDONE activities from the list of "+ listName){
                            public void actionPerformed(ActionEvent arg0) {
                                panel.remove(pnlFromRadioButton);
                                pnlFromRadioButton.removeAll();
                                panel.revalidate();
                                panel.repaint();
                                String listName = tcw06_01_001_f01.getText();
                                pnlFromRadioButton.setBorder(BorderFactory.createTitledBorder("List of activities TO BE DONE from the list of "+ listName));
                                int butt2selectActNum = -1;
                                for (String btnText : actItemhw06_01_016) {
                                    butt2selectActNum ++;
                                    if(actStatushw06_01_016.get(butt2selectActNum) == false) {
                                        JRadioButton radioBtn = new JRadioButton(btnText);
                                        radioBtn.setActionCommand(btnText);
                                        btnGroup.add(radioBtn);
                                        pnlFromRadioButton.add(radioBtn);
                                    }
                                }
                                panel.add(pnlFromRadioButton);
                            }
                        });
                        JButton buttonChooseDoneList = new JButton(new AbstractAction("Get to Choose DONE activities from the list of "+ listName){
                            public void actionPerformed(ActionEvent arg0) {
                                panel.remove(pnlFromRadioButton);
                                pnlFromRadioButton.removeAll();
                                panel.revalidate();
                                panel.repaint();
                                String listName = tcw06_01_001_f01.getText();
                                pnlFromRadioButton.setBorder(BorderFactory.createTitledBorder("List of DONE activities from the list of "+ listName));
                                int butt2selectActNum = -1;
                                for (String btnText : actItemhw06_01_016) {
                                    butt2selectActNum ++;
                                    if(actStatushw06_01_016.get(butt2selectActNum) == true) {
                                        JRadioButton radioBtn = new JRadioButton(btnText);
                                        radioBtn.setActionCommand(btnText);
                                        btnGroup.add(radioBtn);
                                        pnlFromRadioButton.add(radioBtn);
                                    }
                                }
                                panel.add(pnlFromRadioButton);
                            }
                        });
                        JButton buttonCheck = new JButton(new AbstractAction("Change the status of the CHOSEN activity from the list of "+ listName){
                            public void actionPerformed(ActionEvent arg0) {
                                ButtonModel selectedModel = btnGroup.getSelection();
                                String butt2select="";
                                if (selectedModel != null) {
                                    selectionField.setText(selectedModel.getActionCommand());
                                    butt2select = (selectedModel.getActionCommand());
//                                    System.out.println("The selected radio button is: " + butt2select);
                                }
                                int butt2selectActNum = -1;
                                for (String btnText : actItemhw06_01_016) {
                                    butt2selectActNum++;
                                    if (btnText == butt2select) {
                                        if (actStatushw06_01_016.get(butt2selectActNum) == false) {
                                            actStatushw06_01_016.set(butt2selectActNum, true);
                                        } else {
                                            actStatushw06_01_016.set(butt2selectActNum, false);
                                        }
                                    }
//                                    System.out.println("The radio button: " + butt2selectActNum +". Value :" + arrhw06_01_001_doneIn01[butt2selectActNum]+"vvv"+BUTTON_TEXTS_jk[0]);
//                                    System.out.println("The radio button: " + butt2selectActNum +". Value :" + arrhw06_01_001_doneIn01[butt2selectActNum]);
                                }
                            }
                        });
                        panel.add(buttonChooseFullList);
                        panel.add(buttonChoosePlanList);
                        panel.add(buttonChooseDoneList);
                        panel.add(buttonCheck);
                        panel.add(selectionField);
                        listName = tcw06_01_001_f01.getText();
                        JFrame frame = new JFrame("Activities PROCESSING (from the activities list of "+listName+")");

                        frame.getContentPane().add(panel);

                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.pack();
                        frame.setLocationRelativeTo(null);
                        frame.setVisible(true);
                    }
                });
                panel.add(buttonSaveListItem);
                panel.add(tcw06_01_001_f02);
                panel.add(buttonSaveList);
                listName = tcw06_01_001_f01.getText();
                JFrame frame = new JFrame("Insert activities into activities list of "+listName);
                frame.getContentPane().add(panel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
        panel.add(buttonSaveListName);
        panel.add(tcw06_01_001_f01);

        JFrame frame = new JFrame("Insert the activities list NAME");
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    private void  butt_05_scope() {
        this.JPanel1();
    }
    public static void main(String[] args) {
        hw06_01_016 bf = new hw06_01_016();
    }
}