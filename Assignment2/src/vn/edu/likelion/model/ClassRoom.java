package vn.edu.likelion.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassRoom {
    private List<Student> list = new ArrayList<>();
    private int totalList;
    private Map<Student, String> blackList = new HashMap<>();
    private LocalDate StartDate;

    // Getter
    public List<Student> getList() {
        return list;
    }
    public int getTotalList() {
        return totalList;
    }
    public Map<Student, String> getBlackList() {
        return blackList;
    }
    public LocalDate getStartDate() {
        return StartDate;
    }
    // Setter
    public void setList(List<Student> list) {
        this.list = list;
    }
    public void setTotalList(int totalList) {
        this.totalList = totalList;
    }
    public void setBlackList(Map<Student, String> blackList) {
        this.blackList = blackList;
    }
    public void setStartDate(LocalDate startDate) {
        StartDate = startDate;
    }

    public void enrol(Student student){
        this.list.add(student);
        totalList++;
        student.setMssv(totalList);
    }
    public void dismiss(Student student, String reason){
        this.blackList.put(student, reason);
    }
    public void showListInfo(){
        for( Student e: list ){
            e.showInfo();
        }
    }
    public boolean memberShipRequirements(Student student){
        int AgeRequirements = LocalDate.now().getYear() - student.getBirthDate().getYear();
        return AgeRequirements >= 18 && AgeRequirements <= 20;
    }
}
