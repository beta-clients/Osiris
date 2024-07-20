package net.minecraft.src;

final class StatTypeSimple implements IStatType
{
    StatTypeSimple()
    {
    }

    /**
     * Formats a given stat for human consumption.
     */
    public String format(int par1)
    {
        return StatBase.getNumberFormat().format(par1);
    }
}
