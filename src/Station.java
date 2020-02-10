public class Station
{
    private Switch switchOne;
    private Switch switchTwo;

    private Track trackOne;
    private Track trackTwo;
    private Track trackRight;
    private Track trackLeft;

    public boolean CanArrive (int arriveAt)
    {
        if (trackOne.Value == 1 && trackTwo.Value == 1)
        {
            return false; //no track available
        }
       return true;
    }

    public void Arrive(int arriveAt, int arriveFrom)
    {
        switch (arriveAt)
        {
            case 1: trackOne.setValue(0);
                break;
            case 2: trackTwo.setValue(0);
                break;
        }
        switch (arriveFrom)
        {
            case 1:
                trackLeft.setValue(0);
                break;
            case 2:
                trackRight.setValue(0);
        }
    }

    public boolean CanDepart (int departTo)
    {
        switch (departTo)
        {
            case 1:
                if (trackLeft.Value == 0)
                {
                    return true;
                }
                break;
            case 2:
                if (trackRight.Value == 0)
                {
                    return true;
                }
                break;
        }
        return false;
    }

    public void Depart (int departFrom, int departTo)
    {
        switch (departFrom)
        {
            case 1:
                trackOne.setValue(0);
                break;
            case 2:
                trackTwo.setValue(0);
        }
        switch (departTo)
        {
            case 1:
                trackLeft.setValue(1);
                break;
            case 2:
                trackRight.setValue(1);
        }
    }

    public void GoToStation (int trackToStation)
    {
        switch (trackToStation)
        {
            case 1:
                trackLeft.setValue(1);
                break;
            case 2:
                trackRight.setValue(1);
        }
    }

    public boolean isTrackAvailable ()
    {
        return (CanArrive(1)
                || CanArrive(2)
                || (CanDepart(1) && CanDepart(2)));
    }
}
