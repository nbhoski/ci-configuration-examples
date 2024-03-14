package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.BuildType
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, create a buildType with id = 'CsEscaltion'
in the root project, and delete the patch script.
*/
create(DslContext.projectId, BuildType({
    id("CsEscaltion")
    name = "CS-Escaltion"

    steps {
        script {
            id = "simpleRunner"
            scriptContent = """
                echo "Running script from example"
                matlab -nosplash -noFigureWindows -sd "C:\Users\nbhoski\Documents\example" -batch "ps = parallel.Settings;ps.Pool.PreferredNumWorkers = 2;ps.Pool.AutoCreate = true;slbuild('top', 'StandaloneCoderTarget', 'ForceTopModelBuild', true);"
                echo "complete !"
            """.trimIndent()
        }
    }
}))

