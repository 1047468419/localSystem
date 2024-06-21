package com.dong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HoverPanel extends JPanel {

    private boolean isHovering = false;
    private Color hoverColor = Color.YELLOW;
    private Color normalColor = Color.WHITE;

    public HoverPanel() {
        // 添加鼠标适配器以监听鼠标事件
        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                // 当鼠标移入面板时改变背景色
                if (e.getSource() == HoverPanel.this && HoverPanel.this.contains(e.getPoint())) {
                    isHovering = true;
                    HoverPanel.this.setBackground(hoverColor);
                } else {
                    isHovering = false;
                    HoverPanel.this.setBackground(normalColor);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // 当鼠标移出面板时恢复背景色
                if (!HoverPanel.this.contains(e.getPoint())) {
                    isHovering = false;
                    HoverPanel.this.setBackground(normalColor);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Hover Panel Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            HoverPanel panel = new HoverPanel();
            frame.add(panel);

            frame.setVisible(true);
        });
    }
}