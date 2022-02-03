package essam.com.example.Shift.Application.models;

import essam.com.example.Shift.Application.enums.ShiftStatus;
import essam.com.example.Shift.Application.grpc.Shifts;
import essam.com.example.Shift.Application.requests.CreateShiftRequest;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "shifts")
public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double assigneeRate = 0;

    private double creatorRate = 0;

    private double fees = 0;

    @Enumerated(EnumType.STRING)
    private ShiftStatus status = ShiftStatus.SCHEDULED;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date clockIn;

    @Temporal(TemporalType.TIMESTAMP)
    private Date clockOut;

    private double assigneePayment = 0;

    private double creatorPayment = 0;

    @Temporal(TemporalType.TIMESTAMP)
    private final Date createdAt = new Date();

    @ManyToOne
    @JoinColumn(name = "creator_id", nullable = false)
    private User creator;

    @ManyToOne
    @JoinColumn(name = "assignee_id")
    private User assignee;

    public Shift() {}

    public Shift(User creator, CreateShiftRequest request) {
        this.creator = creator;
        this.startTime = request.getStartTime();
        this.endTime = request.getEndTime();
    }

    public Shift(User creator, Shifts.CreateShiftRequest request) {
        this.creator = creator;
        this.startTime = new Date(request.getStartTime());
        this.endTime = new Date(request.getStartTime());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAssigneeRate() {
        return assigneeRate;
    }

    public void setAssigneeRate(double assigneeRate) {
        this.assigneeRate = assigneeRate;
    }

    public double getCreatorRate() {
        return creatorRate;
    }

    public void setCreatorRate(double creatorRate) {
        this.creatorRate = creatorRate;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public ShiftStatus getStatus() {
        return status;
    }

    public void setStatus(ShiftStatus status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getClockIn() {
        return clockIn;
    }

    public void setClockIn(Date clockIn) {
        this.clockIn = clockIn;
    }

    public Date getClockOut() {
        return clockOut;
    }

    public void setClockOut(Date clockOut) {
        this.clockOut = clockOut;
    }

    public double getAssigneePayment() {
        return assigneePayment;
    }

    public void setAssigneePayment(double assigneePayment) {
        this.assigneePayment = assigneePayment;
    }

    public double getCreatorPayment() {
        return creatorPayment;
    }

    public void setCreatorPayment(double creatorPayment) {
        this.creatorPayment = creatorPayment;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }
}
