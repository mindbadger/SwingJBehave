
require 'build_version_numbers'
require 'build_dependencies'

define 'SwingJBehave' do
  project.version = VERSION_NUMBER
  project.group = 'mindbadger.bdd'
  
  compile('src').with(HAMCREST, JBEHAVE)
  
  pack = package(:jar)  
end
