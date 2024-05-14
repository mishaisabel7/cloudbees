release 'Jenkins', {
  plannedEndDate = '2023-11-08T11:51'
  plannedStartDate = '2023-10-25T11:51'
  projectName = 'Proyecto_cloudbees'

  pipeline 'pipeline_Jenkins', {
    releaseName = 'Jenkins'

    formalParameter 'ec_stagesToRun', {
      expansionDeferred = '1'
    }

    stage 'Stage 1', {
      pipelineName = 'pipeline_Jenkins'
      task 'Compilar Job', {
        actualParameter = [
          'config_name': '/projects/Proyecto_cloudbees/pluginConfigurations/Jenkins',
          'jenkins_depend_on_build_result': '0',
          'jenkins_enable_parallel_mode': '0',
          'job_name': 'Hello world',
          'need_to_run_report': '1',
          'parameters': 'name=Isabel',
        ]
        resourceName = 'local'
        subpluginKey = 'EC-Jenkins'
        subprocedure = 'RunAndWait'
        taskType = 'PLUGIN'
      }
    }

    stage 'Stage 2', {
      colorCode = '#ff7f0e'
      pipelineName = 'pipeline_Jenkins'
      task 'Feedback', {
        actualParameter = [
          'build_number': '',
          'config_name': '/projects/Proyecto_cloudbees/pluginConfigurations/Jenkins',
          'job_name': 'Hello world',
          'need_to_run_report': '1',
          'result_outpp': '/myJobStep/buildDetails',
        ]
        resourceName = 'local'
        subpluginKey = 'EC-Jenkins'
        subprocedure = 'GetBuildDetails'
        taskType = 'PLUGIN'
      }
    }

    stage 'Stage 3', {
      colorCode = '#2ca02c'
      pipelineName = 'pipeline_Jenkins'
      task 'Sonarqube', {
        subproject = 'Proyecto_cloudbees'
      }
    }

    // Custom properties

    property 'ec_counters', {

      // Custom properties
      pipelineCounter = '13'
    }
  }
}