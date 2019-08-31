package osu.cse2221;

import java.util.ArrayList;

/**
 * GroupList is a class that enable fast access to celestrial bodie's name and
 * its corresponding period. Also, it help classifing whether two celestrial
 * bodies are in same system. * @author Chenjie Wu
 *
 */
public class GroupList {
    private ArrayList<String> celesName;
    private ArrayList<Double> celesPeriod;
    private ArrayList<Integer> group;

    /**
     *
     * @param names
     *            The ArrayList of names of celestrial bodies.
     * @param period
     *            The ArrayList of their orbital periods.
     * @param group
     *            The ArrayList of their assigned groups.
     */
    public GroupList(ArrayList<String> names, ArrayList<Double> period,
            ArrayList<Integer> group) {

        this.celesName = new ArrayList<>();
        this.celesPeriod = new ArrayList<>();
        this.group = new ArrayList<>();
        for (String ele : names) {
            this.celesName.add(ele);
        }
        for (Double ele : period) {
            this.celesPeriod.add(ele);
        }
        for (int ele : group) {
            this.group.add(ele);
        }
    }

    /**
     * Constructor
     */
    public GroupList() {
        this.celesName = new ArrayList<>();
        this.celesPeriod = new ArrayList<>();
        this.group = new ArrayList<>();
    }

    /**
     * Add a celestrial body to the list
     * 
     * @param name
     *            Celestrial body name
     * @param period
     *            Celestrial body orbital period
     * @param group
     *            Celestrial body assigned group
     */
    public void add(String name, double period, int group) {
        this.celesName.add(name);
        this.celesPeriod.add(period);
        this.group.add(group);
    }

    /**
     * Get the period of celestrial body.
     * 
     * @param index
     *            Index of celestrial body.
     * @return
     */
    public double getPeriod(int index) {
        return this.celesPeriod.get(index);
    }

    /**
     * Get the period of celestrial body.
     * 
     * @param name
     *            Name of celestrial body.
     * @return the period.
     */
    public double getPeriod(String name) {
        for (int i = 0; i < this.celesName.size(); i++) {
            if (name.equals(this.celesName.get(i))) {
                return this.celesPeriod.get(i);
            }
        }

        return 0.0;
    }

    /**
     * Get the group of celestrial body.
     * 
     * @param index
     *            Index of celestrial body.
     * @return The group number of celestrial body.
     */
    public int getGroup(int index) {
        return this.group.get(index);
    }

    /**
     * Get the group of celestrial body.
     * 
     * @param name
     *            Name of celestrial body.
     * @return The group number of celestrial body.
     */
    public int getGroup(String name) {
        for (int i = 0; i < this.celesName.size(); i++) {
            if (name.equals(this.celesName.get(i))) {
                return this.group.get(i);
            }
        }

        return 0;
    }

    /**
     * Estimate if two celestrial groups are in the same group.
     * 
     * @param index1
     *            The index of first celestrial body.
     * @param index2
     *            The index of second celestrial body.
     * @return Whether they are in the same group.
     */
    public boolean isSameGroup(int index1, int index2) {
        return this.group.get(index1) == this.group.get(index2);
    }

    /**
     * Estimate if two celestrial groups are in the same group.
     * 
     * @param name1
     *            The name of first celestrial body.
     * @param name2
     *            The name of second celestrial body.
     * @return Whether they are in the same group.
     */
    public boolean isSameGroup(String name1, String name2) {
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < this.celesName.size(); i++) {
            if (name1.equals(this.celesName.get(i))) {
                index1 = i;
            }
            if (name2.equals(this.celesName.get(i))) {
                index2 = i;
            }
        }
        return this.group.get(index1) == this.group.get(index2);
    }

}
