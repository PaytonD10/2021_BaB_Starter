package team.gif.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import team.gif.robot.Globals;

public class NEOStart extends CommandBase
{

    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

    public NEOStart()
    {

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize()
    {

    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute()
    {
        NEOShooter.getInstance().setRPM(60);
    }

    @Override
    public boolean isFinished()
    {
        return false;
    }

    // Returns true when the command is about to end.
    // Should be called once the command ends.
    @Override
    public void end(boolean interrupted)
    {
        NEOShooter.getInstance().setRPM(0);
        Globals.g_buttonControl = false;
    }
}

