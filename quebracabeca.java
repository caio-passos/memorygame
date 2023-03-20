import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class quebracabeca extends JFrame {
    private JButton[][][] buttons;
    private int[][][] values;
    private int count;
    private int[] firstIndex;
    private int[] secondIndex;

    public quebracabeca() {
        buttons = new JButton[3][3][3];
        values = new int[3][3][3];
        count = 0;
        firstIndex = new int[3];
        secondIndex = new int[3];

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,3,5,5));

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                for(int k=0;k<3;k++){
                    buttons[i][j][k] = new JButton("?");
                    buttons[i][j][k].addActionListener(new ButtonListener(i,j,k));
                    panel.add(buttons[i][j][k]);
                }
            }
        }

        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
    }

    private class ButtonListener implements ActionListener{
        private int x,y,z;

        public ButtonListener(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public void actionPerformed(ActionEvent e){
            if(count==0){
                firstIndex[0] = x;
                firstIndex[1] = y;
                firstIndex[2] = z;
                buttons[x][y][z].setText(""+values[x][y][z]);
                count++;
            } else if(count==1){
                secondIndex[0] = x;
                secondIndex[1] = y;
                secondIndex[2] = z;
                buttons[x][y][z].setText(""+values[x][y][z]);
                count++;

                if(values[firstIndex[0]][firstIndex[1]][firstIndex[2]]==values[secondIndex[0]][secondIndex[1]][secondIndex[2]]){
                    JOptionPane.showMessageDialog(null, "Match Found!");
                    buttons[firstIndex[0]][firstIndex[1]][firstIndex[2]].setEnabled(false);
                    buttons[secondIndex[0]][secondIndex[1]][secondIndex[2]].setEnabled(false);
                    count = 0;
                } else {
                    JOptionPane.showMessageDialog(null, "No Match Found!");
                    buttons[firstIndex[0]][firstIndex[1]][firstIndex[2]].setText("?");
                    buttons[secondIndex[0]][secondIndex[1]][secondIndex[2]].setText("?");
                    count = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        quebracabeca game = new quebracabeca();
    }
}
