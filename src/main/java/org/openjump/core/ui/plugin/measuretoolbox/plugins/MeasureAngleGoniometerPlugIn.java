package org.openjump.core.ui.plugin.measuretoolbox.plugins;

import javax.swing.ImageIcon;

import org.openjump.core.ui.plugin.measuretoolbox.cursortools.MeasureAngleGoniometerTool;
import org.openjump.core.ui.plugin.measuretoolbox.icons.IconLoader;
import org.openjump.core.ui.plugin.measuretoolbox.language.I18NPlug;
import com.vividsolutions.jump.workbench.WorkbenchContext;
import com.vividsolutions.jump.workbench.plugin.AbstractPlugIn;
import com.vividsolutions.jump.workbench.plugin.EnableCheckFactory;
import com.vividsolutions.jump.workbench.plugin.MultiEnableCheck;
import com.vividsolutions.jump.workbench.plugin.PlugInContext;
import com.vividsolutions.jump.workbench.ui.cursortool.QuasimodeTool;

/**
 * measures angle by goniometer
 *
 * @author Giuseppe Aruta - Sept 1th 2015
 */
public class MeasureAngleGoniometerPlugIn extends AbstractPlugIn {

  public static ImageIcon ICON = IconLoader.icon("Ruler_goniometer.gif");
  public static final String NAME = I18NPlug
      .getI18N("MeasureToolbox.MeasureTools.Goniometer");

  @Override
  public boolean execute(PlugInContext context) throws Exception {
    reportNothingToUndoYet(context);

    context.getLayerViewPanel().setCurrentCursorTool(QuasimodeTool.createWithDefaults(
        new MeasureAngleGoniometerTool(context)));
    return true;
  }

  public ImageIcon getIcon() {
    return ICON;
  }

  @Override
  public String getName() {
    return NAME;
  }

  public static MultiEnableCheck createEnableCheck(
      WorkbenchContext workbenchContext) {
    EnableCheckFactory checkFactory = new EnableCheckFactory(
        workbenchContext);

    return new MultiEnableCheck().add(checkFactory
        .createWindowWithSelectionManagerMustBeActiveCheck());
  }
}
