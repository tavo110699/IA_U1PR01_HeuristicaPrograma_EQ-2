/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astar;

import astar.MyLabel;
import astar.PanelMouseClickListener;
import astar.Point;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

/**
 *
 * @author Marlic
 */
public class aStarPanel extends javax.swing.JPanel implements Observer {

    public AStarThread aStarThread;
    public Thread thread;

    public MyLabel[][] labelArray;
    public int[][] gridArray;

    public Point start;
    public Point meta;
    public Point Obstacle;

    public boolean isMappedGenerated = false;

    /**
     * Creates new form aStarPanel
     */
    public aStarPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        generateButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtObstacle = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        obstacleRB = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        delayTextField = new javax.swing.JTextField();
        startButton = new javax.swing.JButton();
        pauseButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        panelContainer = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        generateButton.setText("Generar grid");
        generateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateButtonActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Obstaculos"));

        txtObstacle.setText("10");

        jLabel3.setText("obstaculos Aleatorios");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingresa Manual"));

        obstacleRB.setText("Obstacle");
        obstacleRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obstacleRBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addComponent(obstacleRB)
                    .addContainerGap(63, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addComponent(obstacleRB)
                    .addContainerGap(12, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtObstacle, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtObstacle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Controles"));

        jLabel1.setText("Delay[ms]");

        delayTextField.setText("0");

        startButton.setText("Iniciar");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        pauseButton.setText("Pausar");
        pauseButton.setEnabled(false);
        pauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseButtonActionPerformed(evt);
            }
        });

        stopButton.setText("Detener");
        stopButton.setEnabled(false);
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear");
        clearButton.setEnabled(false);
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(startButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pauseButton))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delayTextField)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(stopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(clearButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearButton)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(delayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startButton)
                    .addComponent(pauseButton)
                    .addComponent(stopButton))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(generateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(generateButton)
                .addGap(101, 101, 101))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelContainer.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelContainerLayout = new javax.swing.GroupLayout(panelContainer);
        panelContainer.setLayout(panelContainerLayout);
        panelContainerLayout.setHorizontalGroup(
            panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 766, Short.MAX_VALUE)
        );
        panelContainerLayout.setVerticalGroup(
            panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateButtonActionPerformed
        try {
            String rowsTF = (String) JOptionPane.showInputDialog(
                    aStarPanel.this,
                    "Enter grid size (5 - 30)",
                    "Generating grid",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    "");
            int rows = Integer.parseInt(rowsTF);
            if (rows >= 5 && rows <= 30) {

                fillPanelContainer(rows);

                // INICIO 
                MyLabel labelStart = new MyLabel(0, 0);
                Point positionStart = new Point(labelStart.getPX(), labelStart.getPY());
                start = positionStart;
                labelArray[start.x][start.y].setBackground(Color.ORANGE);

                // FIN
                MyLabel labelMeta = new MyLabel(rows - 1, rows - 1);
                Point positionMeta = new Point(labelMeta.getPX(), labelMeta.getPY());
                meta = positionMeta;
                labelArray[meta.x][meta.y].setBackground(Color.BLUE);

                // OBSTACLE
                int size = Integer.parseInt(txtObstacle.getText());
                int[] vectorX = new int[size];
                int[] vectorY = new int[size];
                for (int i = 0; i < size; i++) {
                    vectorX[i] = new Random().nextInt(rows - 1);
                    vectorY[i] = new Random().nextInt(rows - 1);

                }
                gridArray = new int[rows][rows];
                for (int i = 0; i < size; i++) {
                    if (vectorX[i] == 9 && vectorY[i] == 9) {
                        if (vectorX[i] == 0 && vectorY[i] == 0) {
                            System.out.println("Ocurrio un errir en obstaculos");
                        }
                    } else {
                        MyLabel labelObstacle = new MyLabel(vectorX[i], vectorY[i]);
                        Point positionObstacle = new Point(labelMeta.getPX(), labelMeta.getPY());
                        Obstacle = positionObstacle;
                        // labelArray[Obstacle.x][Obstacle.y].setBackground(Color.RED);
                        //   labelObstacle.setBackground(Color.red);
                        //  gridArray[Obstacle.x][Obstacle.y] = 5;

                        if (((start != null && (start.x != positionObstacle.x || start.y != positionObstacle.y)) || start == null)
                                && (meta != null && (meta.x != positionObstacle.x || meta.y != positionObstacle.y)) || meta == null) {
                            if (gridArray[positionObstacle.x][positionObstacle.y] != 5) {
                                labelObstacle.setBackground(Color.red);
                                gridArray[positionObstacle.x][positionObstacle.y] = 5;
    
                            } else {
                                labelObstacle.setBackground(Color.white);
                                gridArray[positionObstacle.x][positionObstacle.y] = 0;
                            }
                        }

                    }

                }

            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_generateButtonActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        int delay = 0;

        try {
            delay = Integer.parseInt(delayTextField.getText().toString());
        } catch (Exception e) {
        }

        delayTextField.setText(String.valueOf(delay));

        if (start == null) {
            JOptionPane.showMessageDialog(this, "Start point has not been established", "", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (meta == null) {
            JOptionPane.showMessageDialog(this, "Target point has not been established", "", JOptionPane.ERROR_MESSAGE);
            //zaznacz metę
            return;
        }

        clear();

        startButton.setEnabled(false);
        pauseButton.setEnabled(true);
        stopButton.setEnabled(true);

        obstacleRB.setEnabled(false);
        clearButton.setEnabled(false);
        delayTextField.setEnabled(false);

        generateButton.setEnabled(false);

        aStarThread = new AStarThread(this, start, meta, labelArray, gridArray, delay);

        aStarThread.addObserver(this);
        thread = new Thread(aStarThread);
        thread.start();
    }//GEN-LAST:event_startButtonActionPerformed

    private void pauseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseButtonActionPerformed
        String text = pauseButton.getText().toString();

        if (text.equals("Pause")) {
            aStarThread.isPaused = true;
            pauseButton.setText("Resume");
        } else {
            aStarThread.isPaused = false;
            pauseButton.setText("Pause");

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_pauseButtonActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        aStarThread.isStopped = true;
    }//GEN-LAST:event_stopButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clear();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void obstacleRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obstacleRBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_obstacleRBActionPerformed

    /**
     * Generowanie tablicy
     */
    private void fillPanelContainer(int x) {
        panelContainer.removeAll();
        panelContainer.revalidate();
        panelContainer.repaint();

        panelContainer.getWidth();
        panelContainer.getHeight();

        start = null;
        meta = null;

        int squareSize = panelContainer.getWidth() / x;

        panelContainer.setLayout(new GridLayout(x, x));

        labelArray = new MyLabel[x][x];
        gridArray = new int[x][x];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                MyLabel label = new MyLabel(i, j);
                label.setBorder(BorderFactory.createLineBorder(Color.black, 1));

                int withoutBorder = squareSize;

                label.setMaximumSize(new Dimension(withoutBorder, withoutBorder));
                label.setMaximumSize(new Dimension(withoutBorder, withoutBorder));
                label.setPreferredSize(new Dimension(withoutBorder, withoutBorder));
                label.setOpaque(true);
                label.setBackground(Color.white);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setVerticalAlignment(SwingConstants.CENTER);

                labelArray[i][j] = label;

                label.addMouseListener(new PMouseClickListener());
                panelContainer.add(label);
            }
        }

        isMappedGenerated = true;
    }

    class PMouseClickListener extends PanelMouseClickListener {

        @Override
        public void mousePressed(MouseEvent e) {

            MyLabel label = (MyLabel) e.getComponent();

            Point position = new Point(label.getPX(), label.getPY());
            if (obstacleRB.isSelected()) {
                if (((start != null && (start.x != position.x || start.y != position.y)) || start == null)
                        && (meta != null && (meta.x != position.x || meta.y != position.y)) || meta == null) {
                    if (gridArray[position.x][position.y] != 5) {
                        label.setBackground(Color.red);
                        gridArray[position.x][position.y] = 5;
                    } else {
                        label.setBackground(Color.white);
                        gridArray[position.x][position.y] = 0;
                    }
                }
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        pauseButton.setText("Pause");

        delayTextField.setEnabled(true);
        startButton.setEnabled(true);
        pauseButton.setEnabled(false);
        stopButton.setEnabled(false);

        obstacleRB.setEnabled(true);
        clearButton.setEnabled(true);

        generateButton.setEnabled(true);
    }

    private void clear() {
        for (int i = 0; i < labelArray.length; i++) {
            for (int j = 0; j < labelArray.length; j++) {
                if ((start.x != i || start.y != j) && (meta.x != i || meta.y != j) && gridArray[i][j] != 5) {
                    labelArray[i][j].setBackground(Color.WHITE);
                }
                labelArray[i][j].setText("");
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearButton;
    private javax.swing.JTextField delayTextField;
    private javax.swing.JButton generateButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton obstacleRB;
    private javax.swing.JPanel panelContainer;
    private javax.swing.JButton pauseButton;
    private javax.swing.JButton startButton;
    private javax.swing.JButton stopButton;
    private javax.swing.JTextField txtObstacle;
    // End of variables declaration//GEN-END:variables
}