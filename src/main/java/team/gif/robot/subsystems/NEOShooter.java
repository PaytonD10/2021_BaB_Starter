package team.gif.robot.subsystems;


import com.revrobotics.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;


public class NEOShooter extends SubsystemBase {
    private static NEOShooter instance = null;

    // creates a singleton class (only 1 instance can be instantiated)
    public static NEOShooter getInstance() {
        if (instance == null) {
            instance = new NEOShooter();
        }
        return instance;
    }


    private static final CANSparkMax NEO = new CANSparkMax(RobotMap.MOTOR_SPARKMAX_ONE, CANSparkMaxLowLevel.MotorType.kBrushless);
    private static final CANEncoder NEOEncoder = NEO.getEncoder();
    private static final CANPIDController NEOPIDController = NEO.getPIDController();

    int stallMaxAmps = 40;

    public NEOShooter(){
        super();
        NEO.restoreFactoryDefaults();
        NEO.enableVoltageCompensation(12);
        NEO.setIdleMode(CANSparkMax.IdleMode.kCoast);
        NEOPIDController.setP(0.00003);
        NEOPIDController.setFF(0.00030);
        NEO.setSmartCurrentLimit(stallMaxAmps,stallMaxAmps);
        NEOPIDController.setOutputRange(0, 1);

    }

    public void setVoltage(double voltage) {
        NEO.setVoltage(voltage);
    }

    public double getVelocity () { return NEOEncoder.getVelocity();}
    public void setRPM (double setPoint) {
        NEOPIDController.setReference(setPoint, ControlType.kVelocity);

    }
    public String getVelocity_Shuffleboard(){ return String.format("%12.0f",getVelocity());}

}
