package com.vas.muscleapp.commands;

public class BodyMeasurementsCreateCommand implements CommandBase {

	@Override
	public void execute() {

	}

	@Override
	public void undo() {
		throw new UnsupportedOperationException("Create action can't be undone.");
	}

}
