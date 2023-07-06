package ifsplife.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javaswingdev.GoogleMaterialDesignIcon;
import ifsplife.swing.scroll.ScrollBar;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

public class Menu_adm extends JPanel {

    private int index = -1;
    private final List<EventMenuSelected> events = new ArrayList<>();

    private Color firstColor = Color.decode("#004e92");
    private Color secondColor = Color.decode("#000428");
    private Color textColor = Color.decode("#4EF92F");

    public Menu_adm() {
        init();
    }

    private void init() {
        setBackground(Color.WHITE);
//        setBackground(firstColor);
        setLayout(new BorderLayout());
        JScrollPane scroll = createScroll();
        panelMenu = createPanelMenu();
//        panelMenu.setBackground(secondColor);
        scroll.setViewportView(panelMenu);
        scroll.getViewport().setOpaque(false);
        scroll.setViewportBorder(null);
        add(scroll);
        addTitle("IFSP LIFE");
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.STAR, "Caixa"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.STAR, "Compra"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.STAR, "Vendas"));
        addTitle("INTERNO");
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.STAR, "Fornecedor"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.STAR, "Convênios"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.STAR, "Funcionários"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.STAR, "Produtos"));
        addTitle("RELATÓRIOS");
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.STAR, "Relatório de Compra"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.STAR, "Relatório de Venda"));
        addTitle("MEUS DADOS");
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.STAR, "Perfil"));
    }

    private JScrollPane createScroll() {
        JScrollPane scroll = new JScrollPane();
        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBar(new ScrollBar());
        return scroll;
    }

    private JPanel createPanelMenu() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        menuLayout = new MigLayout("wrap,fillx,inset 0,gapy 0", "[fill]");
        panel.setLayout(menuLayout);

        return panel;
    }

    private JPanel createMenuItem(ModelMenuItem item) {
        MenuItem menuItem = new MenuItem(item, ++index, menuLayout);
        menuItem.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int index, int indexSubMenu) {
                if (!menuItem.isHasSubMenu() || indexSubMenu != 0) {
                    clearSelected();
                    setSelectedIndex(index, indexSubMenu);
                }
            }
        });
        return menuItem;
    }

    private void runEvent(int index, int indexSubMenu) {
        for (EventMenuSelected event : events) {
            event.menuSelected(index, indexSubMenu);
        }
    }

    //  Public Method
    public void addMenuItem(ModelMenuItem menu) {
        panelMenu.add(createMenuItem(menu), "h 35!");
    }

    public void addTitle(String title) {
        JLabel label = new JLabel(title);
        label.setBorder(new EmptyBorder(15, 20, 5, 5));
        label.setFont(label.getFont().deriveFont(Font.BOLD));
        label.setForeground(textColor);
        panelMenu.add(label);
    }

    public void addSpace(int size) {
        panelMenu.add(new JLabel(), "h " + size + "!");
    }

    public void setSelectedIndex(int index, int indexSubMenu) {
        for (Component com : panelMenu.getComponents()) {
            if (com instanceof MenuItem) {
                MenuItem item = (MenuItem) com;
                if (item.getIndex() == index) {
                    item.setSelectedIndex(indexSubMenu);
                    runEvent(index, indexSubMenu);
                    break;
                }
            }
        }
    }

    public void clearSelected() {
        for (Component com : panelMenu.getComponents()) {
            if (com instanceof MenuItem) {
                MenuItem item = (MenuItem) com;
                item.clearSelected();
            }
        }
    }

    public void addEvent(EventMenuSelected event) {
        events.add(event);
    }

    private MigLayout menuLayout;
    private JPanel panelMenu;
}